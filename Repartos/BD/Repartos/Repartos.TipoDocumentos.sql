USE "Repartos";
GO

SET ANSI_NULLS ON;
GO

SET QUOTED_IDENTIFIER ON;
GO


IF NOT EXISTS
(
	SELECT
		"is_external"
	FROM
		"sys"."tables" AS "t" INNER JOIN
		"sys"."schemas" AS "s" ON
		"t"."schema_id" = "s"."schema_id" AND
		"s"."name" = N'Repartos' AND
		"t"."name" = N'TipoDocumentos'
)
BEGIN
	CREATE TABLE "Repartos"."TipoDocumentos"
	(
		"Id" "tinyint" NOT NULL,
		"Nombre" "varchar"(32) NOT NULL,
		CONSTRAINT "PK_TipoDocumentos" PRIMARY KEY CLUSTERED 
		(
			"Id" ASC
		)
		WITH
		(
			PAD_INDEX = OFF,
			STATISTICS_NORECOMPUTE = OFF,
			IGNORE_DUP_KEY = OFF,
			ALLOW_ROW_LOCKS = ON,
			ALLOW_PAGE_LOCKS = ON,
			OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF
		) ON "PRIMARY"
	) ON "PRIMARY"
END;
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Almacena la información de los tipos de documentos.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'TipoDocumentos';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Código del tipo de documento.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'TipoDocumentos',
	@level2type = N'COLUMN',
	@level2name = N'Id';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Nombre del tipo de documento.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'TipoDocumentos',
	@level2type = N'COLUMN',
	@level2name = N'Nombre';
GO