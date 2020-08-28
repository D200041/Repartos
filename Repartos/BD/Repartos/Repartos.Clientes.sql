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