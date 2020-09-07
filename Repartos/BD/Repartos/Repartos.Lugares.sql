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
		"t"."name" = N'Lugares'
)
BEGIN
	CREATE TABLE "Repartos"."Lugares"
	(
		"Id" "int" IDENTITY(1, 1) NOT NULL,
		"Padre" "integer" NULL,
		"Nombre" "varchar"(32) NOT NULL,
		"Nacionalidad" "varchar"(32) NULL,
		CONSTRAINT "PK_Lugares" PRIMARY KEY CLUSTERED
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
		) ON "PRIMARY",
		CONSTRAINT "UK_Lugares_Id" UNIQUE NONCLUSTERED
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

	ALTER TABLE "Repartos"."Lugares"
	WITH CHECK ADD CONSTRAINT "FK_Lugares_Lugares"
	FOREIGN KEY
	(
		"Padre"
	)
	REFERENCES "Repartos"."Lugares"
	(
		"Id"
	);

	ALTER TABLE "Repartos"."Lugares"
	CHECK CONSTRAINT "FK_Lugares_Lugares";
END;
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Almacena los lugares como barrios, upz, localidades, ciudades, departamentos, países, etc.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Lugares';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Llave autonumérica de la tabla.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Lugares',
	@level2type = N'COLUMN',
	@level2name = N'Id';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Lugar que contiene al lugar correspondiente a este Id.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Lugares',
	@level2type = N'COLUMN',
	@level2name = N'Padre';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Nombre del barrio, upz, localidad, ciudad, departamento, país, etc.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Lugares',
	@level2type = N'COLUMN',
	@level2name = N'Nombre';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Nacionalidad aplicable únicamente a los lugares correspondientes a países.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Lugares',
	@level2type = N'COLUMN',
	@level2name = N'Nacionalidad';
GO