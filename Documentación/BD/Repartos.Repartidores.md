## Descripción



## Propiedades

|Propiedad|Valor|
|---------|-----|
|Fecha De Creación|2020-08-28T19:09:26.197|
|Última Modificación|2020-08-28T19:09:26.203|
|Propietario|dbo|
|Pertenece Al Esquema|Sí|
|Esquema|Repartos|
|Objeto Del Sistema|No|
|Contiene Desencadenadores Después De|No|
|Contiene Desencadenadores De Insersión|No|
|Contiene Desencadenadores De Borrado|No|
|Contiene Desencadenadores De Sustitución|No|
|Contiene Desencadenadores De Actualización|No|
|Tiene Índices|Sí|
|Es Indexable|Sí|
|Tiene Índices Agrupados|Sí|
|Tiene Índices No Agrupados|No|
|Tiene Índices Agrupados Primarios|Sí|
|Tiene Columnas No Agrupadas Para Reindexar|No|
|Tiene Índices XML|No|
|Tiene Índice Amontonado|No|
|Tiene Datos XML|No|
|Tiene Datos Espaciales|No|
|Estado De Comparación Con Nulos|Sí|
|Estado De Comillas Delimitadoras|Sí|
|Grupo De Archivo De Texto||
|Replicada|No|
|Grupo De Archivos|PRIMARY|
|Esquema De Partición||
|Está Particionada|No|

## Columnas

|Nombre|Descripción|Llave Primaria|Llave Foránea|Permite Nulos|Autonumérica|Inicio Autonumérico|Incremento Autonumérico|Tipo De Dato|Esquema Del Tipo De Dato|Tipo De Dato Del Sistema|Tamaño|Precisión|Escala|Intercalación|Calculada|Relleno Ansi|Columna De Indentidad De Fila|Texto Calculado|Persistida|Nombre Del Valor Por Defecto|Esquema Predeterminado|Nombre Restricción Predeterminada|Regla|Esquema De La Regla|Determinística|Precisa|No Para Replicación|Texto Completo Indexado|Documento XML|Espacio De Nombres Del Esquema XML|Esquema Del Espacio De Nombres Del Esquema XML|
|------|-----------|--------------|-------------|-------------|------------|-------------------|-----------------------|------------|------------------------|------------------------|------|---------|------|-------------|---------|------------|-----------------------------|---------------|----------|----------------------------|----------------------|---------------------------------|-----|-------------------|--------------|-------|-------------------|-----------------------|-------------|----------------------------------|----------------------------------------------|
|Id||Sí|No|No|Sí|1|1|int|sys|int|4|10|0||No|No|No||No||||||No|No|False|No|No|||
|TipoDocumento||No|Sí|No|No|0|0|tinyint|sys|tinyint|1|3|0||No|No|No||No||||||No|No|False|No|No|||
|Documento||No|No|No|No|0|0|nvarchar|sys|nvarchar|16|0|0|Latin1_General_CS_AS|No|Sí|No||No||||||No|No|False|No|No|||
|Nombre1||No|No|No|No|0|0|nvarchar|sys|nvarchar|32|0|0|Latin1_General_CS_AS|No|Sí|No||No||||||No|No|False|No|No|||
|Nombre2||No|No|Sí|No|0|0|nvarchar|sys|nvarchar|32|0|0|Latin1_General_CS_AS|No|Sí|No||No||||||No|No|False|No|No|||
|Apellido1||No|No|No|No|0|0|nvarchar|sys|nvarchar|32|0|0|Latin1_General_CS_AS|No|Sí|No||No||||||No|No|False|No|No|||
|Apellido2||No|No|Sí|No|0|0|nvarchar|sys|nvarchar|32|0|0|Latin1_General_CS_AS|No|Sí|No||No||||||No|No|False|No|No|||
|Nacimiento||No|No|No|No|0|0|date|sys|date|3|10|0||No|No|No||No||||||No|No|False|No|No|||
|Nacionalidad||No|Sí|No|No|0|0|int|sys|int|4|10|0||No|No|No||No||||||No|No|False|No|No|||

## Índices

|Nombre|Nombre Automático|Deshabilitado|Llave Primaria|Tipo|Grupo De Archivos|Único|Pertenece A Una Restricción|Ignorar Llaves Duplicadas|Admite Bloqueos De Página|Admite Bloqueos De Fila|Factor De Llenado|Texto Completo|Objeto Del Sistema|Llenar Índice|No Recalcular|Particionado|Esquema De Partición|XML|Padre XML|Tipo De Índice XML Secundario|
|------|-----------------|-------------|--------------|----|-----------------|-----|---------------------------|-------------------------|-------------------------|-----------------------|-----------------|--------------|------------------|-------------|-------------|------------|--------------------|---|---------|-----------------------------|
|PK_Repartidores|No|No|Sí|CLUSTERED|PRIMARY|Sí|No|No|Sí|Sí|0|No|No|No|No|No||No||0|

## Comando SQL

~~~sql
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Repartos].[Repartidores](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TipoDocumento] [tinyint] NOT NULL,
	[Documento] [nvarchar](16) COLLATE Latin1_General_CS_AS NOT NULL,
	[Nombre1] [nvarchar](32) COLLATE Latin1_General_CS_AS NOT NULL,
	[Nombre2] [nvarchar](32) COLLATE Latin1_General_CS_AS NULL,
	[Apellido1] [nvarchar](32) COLLATE Latin1_General_CS_AS NOT NULL,
	[Apellido2] [nvarchar](32) COLLATE Latin1_General_CS_AS NULL,
	[Nacimiento] [date] NOT NULL,
	[Nacionalidad] [int] NOT NULL,
 CONSTRAINT [PK_Repartidores] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [Repartos].[Repartidores]  WITH CHECK ADD  CONSTRAINT [FK_Repartidores_Lugares] FOREIGN KEY([Nacionalidad])
REFERENCES [Repartos].[Lugares] ([Id])
GO
ALTER TABLE [Repartos].[Repartidores] CHECK CONSTRAINT [FK_Repartidores_Lugares]
GO
ALTER TABLE [Repartos].[Repartidores]  WITH CHECK ADD  CONSTRAINT [FK_Repartidores_TipoDocumentos] FOREIGN KEY([TipoDocumento])
REFERENCES [Repartos].[TipoDocumentos] ([Id])
GO
ALTER TABLE [Repartos].[Repartidores] CHECK CONSTRAINT [FK_Repartidores_TipoDocumentos]
GO
~~~


## Usada Por


## Depende De

[Repartos.TipoDocumentos](https://github.com/D200041/Repartos.git/wiki/Repartos.TipoDocumentos)

[Repartos.Lugares](https://github.com/D200041/Repartos.git/wiki/Repartos.Lugares)

