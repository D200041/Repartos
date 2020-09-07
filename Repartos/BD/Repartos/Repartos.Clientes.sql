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
		"t"."name" = N'Clientes'
)
BEGIN
	CREATE TABLE "Repartos"."Clientes"
	(
		"Id" "int" IDENTITY(1, 1) NOT NULL,
		"TipoDocumento" "tinyint" NOT NULL,
		"Documento" "nvarchar"(16) NOT NULL,
		"Nombre1" "nvarchar"(32) NOT NULL,
		"Nombre2" "nvarchar"(32) NULL,
		"Apellido1" "nvarchar"(32) NOT NULL,
		"Apellido2" "nvarchar"(32) NULL,
		"Barrio" "int" NOT NULL,
		"Domicilio" "nvarchar"(64) NOT NULL,
		CONSTRAINT "PK_Clientes" PRIMARY KEY CLUSTERED
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
	
	ALTER TABLE "Repartos"."Clientes"
	WITH CHECK ADD CONSTRAINT "FK_Clientes_Lugares"
	FOREIGN KEY
	(
		"Barrio"
	)
	REFERENCES "Repartos"."Lugares"
	(
		"Id"
	);
	
	ALTER TABLE "Repartos"."Clientes"
	CHECK CONSTRAINT "FK_Clientes_Lugares";
	
	ALTER TABLE "Repartos"."Clientes"
	WITH CHECK ADD CONSTRAINT "FK_Clientes_TipoDocumentos"
	FOREIGN KEY
	(
		"TipoDocumento"
	)
	REFERENCES "Repartos"."TipoDocumentos"
	(
		"Id"
	);
	
	ALTER TABLE "Repartos"."Clientes"
	CHECK CONSTRAINT "FK_Clientes_TipoDocumentos";
END;
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Almacena los datos de los clientes.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Clientes';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Llave autonumérica de la tabla.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Clientes',
	@level2type = N'COLUMN',
	@level2name = N'Id';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Tipo de documento del cliente.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Clientes',
	@level2type = N'COLUMN',
	@level2name = N'TipoDocumento';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Número del documento del cliente.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Clientes',
	@level2type = N'COLUMN',
	@level2name = N'Documento';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Primer nombre del cliente.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Clientes',
	@level2type = N'COLUMN',
	@level2name = N'Nombre1';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Segundo nombre del cliente.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Clientes',
	@level2type = N'COLUMN',
	@level2name = N'Nombre2';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Primer apellido del cliente.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Clientes',
	@level2type = N'COLUMN',
	@level2name = N'Apellido1';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Segundo apellido del cliente.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Clientes',
	@level2type = N'COLUMN',
	@level2name = N'Apellido2';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Barrio en el que vive el cliente.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Clientes',
	@level2type = N'COLUMN',
	@level2name = N'Barrio';
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Dirección en la que vive el cliente.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos',
	@level1type = N'TABLE',
	@level1name = N'Clientes',
	@level2type = N'COLUMN',
	@level2name = N'Domicilio';
GO