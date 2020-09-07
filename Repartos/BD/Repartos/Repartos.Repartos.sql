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
		"t"."name" = N'Repartos'
)
BEGIN
	CREATE TABLE "Repartos"."Repartos"
	(
		"Id" "int" IDENTITY(1, 1) NOT NULL,
		"Fecha" "smalldatetime" NOT NULL,
		"Cliente" "int" NOT NULL,
		"Entregado" "bit" NOT NULL,
		CONSTRAINT "PK_Repartos" PRIMARY KEY CLUSTERED
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
	) ON "PRIMARY";
	
	ALTER TABLE "Repartos"."Repartos"
	WITH CHECK ADD CONSTRAINT "FK_Repartos_Clientes"
	FOREIGN KEY
	(
		"Cliente"
	)
	REFERENCES "Repartos"."Clientes"
	(
		"Id"
	);
	
	ALTER TABLE "Repartos"."Repartos"
	CHECK CONSTRAINT "FK_Repartos_Clientes";
END;
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Almacena la información de los repartos.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Repartos';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Código autonumérico de la tabla.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Repartos',
	@level2type = N'COLUMN',
	@level2name = N'Id';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Fecha del reparto.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Repartos',
	@level2type = N'COLUMN',
	@level2name = N'Fecha';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Cliente a quien va dirigido el reparto.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Repartos',
	@level2type = N'COLUMN',
	@level2name = N'Cliente';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Indica si un reparto fue entregado o no.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Repartos',
	@level2type = N'COLUMN',
	@level2name = N'Entregado';
GO