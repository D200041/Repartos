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