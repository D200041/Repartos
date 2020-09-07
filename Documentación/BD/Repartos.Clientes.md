## Descripción

Almacena los datos de los clientes.

## Propiedades

|Propiedad|Valor|
|---------|-----|
|Fecha De Creación|2020-09-06T21:30:05.060|
|Última Modificación|2020-09-06T21:30:05.077|
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
|Id|Llave autonum�rica de la tabla.|Sí|No|No|Sí|1|1|int|sys|int|4|10|0||No|No|No||No||||||No|No|False|No|No|||
|TipoDocumento|Tipo de documento del cliente.|No|Sí|No|No|0|0|tinyint|sys|tinyint|1|3|0||No|No|No||No||||||No|No|False|No|No|||
|Documento|N�mero del documento del cliente.|No|No|No|No|0|0|nvarchar|sys|nvarchar|16|0|0|Latin1_General_CS_AS|No|Sí|No||No||||||No|No|False|No|No|||
|Nombre1|Primer nombre del cliente.|No|No|No|No|0|0|nvarchar|sys|nvarchar|32|0|0|Latin1_General_CS_AS|No|Sí|No||No||||||No|No|False|No|No|||
|Nombre2|Segundo nombre del cliente.|No|No|Sí|No|0|0|nvarchar|sys|nvarchar|32|0|0|Latin1_General_CS_AS|No|Sí|No||No||||||No|No|False|No|No|||
|Apellido1|Primer apellido del cliente.|No|No|No|No|0|0|nvarchar|sys|nvarchar|32|0|0|Latin1_General_CS_AS|No|Sí|No||No||||||No|No|False|No|No|||
|Apellido2|Segundo apellido del cliente.|No|No|Sí|No|0|0|nvarchar|sys|nvarchar|32|0|0|Latin1_General_CS_AS|No|Sí|No||No||||||No|No|False|No|No|||
|Barrio|Barrio en el que vive el cliente.|No|Sí|No|No|0|0|int|sys|int|4|10|0||No|No|No||No||||||No|No|False|No|No|||
|Domicilio|Direcci�n en la que vive el cliente.|No|No|No|No|0|0|nvarchar|sys|nvarchar|64|0|0|Latin1_General_CS_AS|No|Sí|No||No||||||No|No|False|No|No|||

## Índices

|Nombre|Nombre Automático|Deshabilitado|Llave Primaria|Tipo|Grupo De Archivos|Único|Pertenece A Una Restricción|Ignorar Llaves Duplicadas|Admite Bloqueos De Página|Admite Bloqueos De Fila|Factor De Llenado|Texto Completo|Objeto Del Sistema|Llenar Índice|No Recalcular|Particionado|Esquema De Partición|XML|Padre XML|Tipo De Índice XML Secundario|
|------|-----------------|-------------|--------------|----|-----------------|-----|---------------------------|-------------------------|-------------------------|-----------------------|-----------------|--------------|------------------|-------------|-------------|------------|--------------------|---|---------|-----------------------------|
|PK_Clientes|No|No|Sí|CLUSTERED|PRIMARY|Sí|No|No|Sí|Sí|0|No|No|No|No|No||No||0|

## Comando SQL

~~~sql
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Repartos].[Clientes](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TipoDocumento] [tinyint] NOT NULL,
	[Documento] [nvarchar](16) COLLATE Latin1_General_CS_AS NOT NULL,
	[Nombre1] [nvarchar](32) COLLATE Latin1_General_CS_AS NOT NULL,
	[Nombre2] [nvarchar](32) COLLATE Latin1_General_CS_AS NULL,
	[Apellido1] [nvarchar](32) COLLATE Latin1_General_CS_AS NOT NULL,
	[Apellido2] [nvarchar](32) COLLATE Latin1_General_CS_AS NULL,
	[Barrio] [int] NOT NULL,
	[Domicilio] [nvarchar](64) COLLATE Latin1_General_CS_AS NOT NULL,
 CONSTRAINT [PK_Clientes] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [Repartos].[Clientes]  WITH CHECK ADD  CONSTRAINT [FK_Clientes_Lugares] FOREIGN KEY([Barrio])
REFERENCES [Repartos].[Lugares] ([Id])
GO
ALTER TABLE [Repartos].[Clientes] CHECK CONSTRAINT [FK_Clientes_Lugares]
GO
ALTER TABLE [Repartos].[Clientes]  WITH CHECK ADD  CONSTRAINT [FK_Clientes_TipoDocumentos] FOREIGN KEY([TipoDocumento])
REFERENCES [Repartos].[TipoDocumentos] ([Id])
GO
ALTER TABLE [Repartos].[Clientes] CHECK CONSTRAINT [FK_Clientes_TipoDocumentos]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Llave autonum�rica de la tabla.' , @level0type=N'SCHEMA',@level0name=N'Repartos', @level1type=N'TABLE',@level1name=N'Clientes', @level2type=N'COLUMN',@level2name=N'Id'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Tipo de documento del cliente.' , @level0type=N'SCHEMA',@level0name=N'Repartos', @level1type=N'TABLE',@level1name=N'Clientes', @level2type=N'COLUMN',@level2name=N'TipoDocumento'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'N�mero del documento del cliente.' , @level0type=N'SCHEMA',@level0name=N'Repartos', @level1type=N'TABLE',@level1name=N'Clientes', @level2type=N'COLUMN',@level2name=N'Documento'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Primer nombre del cliente.' , @level0type=N'SCHEMA',@level0name=N'Repartos', @level1type=N'TABLE',@level1name=N'Clientes', @level2type=N'COLUMN',@level2name=N'Nombre1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Segundo nombre del cliente.' , @level0type=N'SCHEMA',@level0name=N'Repartos', @level1type=N'TABLE',@level1name=N'Clientes', @level2type=N'COLUMN',@level2name=N'Nombre2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Primer apellido del cliente.' , @level0type=N'SCHEMA',@level0name=N'Repartos', @level1type=N'TABLE',@level1name=N'Clientes', @level2type=N'COLUMN',@level2name=N'Apellido1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Segundo apellido del cliente.' , @level0type=N'SCHEMA',@level0name=N'Repartos', @level1type=N'TABLE',@level1name=N'Clientes', @level2type=N'COLUMN',@level2name=N'Apellido2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Barrio en el que vive el cliente.' , @level0type=N'SCHEMA',@level0name=N'Repartos', @level1type=N'TABLE',@level1name=N'Clientes', @level2type=N'COLUMN',@level2name=N'Barrio'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Direcci�n en la que vive el cliente.' , @level0type=N'SCHEMA',@level0name=N'Repartos', @level1type=N'TABLE',@level1name=N'Clientes', @level2type=N'COLUMN',@level2name=N'Domicilio'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Almacena los datos de los clientes.' , @level0type=N'SCHEMA',@level0name=N'Repartos', @level1type=N'TABLE',@level1name=N'Clientes'
GO
~~~


## Usada Por

[Repartos.Repartos](https://github.com/D200041/Repartos.git/wiki/Repartos.Repartos)


## Depende De

[Repartos.TipoDocumentos](https://github.com/D200041/Repartos.git/wiki/Repartos.TipoDocumentos)

[Repartos.Lugares](https://github.com/D200041/Repartos.git/wiki/Repartos.Lugares)

