## Descripción

Almacena la informaci�n de los tipos de documentos.

## Propiedades

|Propiedad|Valor|
|---------|-----|
|Fecha De Creación|2020-09-06T21:30:05.017|
|Última Modificación|2020-09-06T21:30:05.063|
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
|Id|C�digo del tipo de documento.|Sí|No|No|No|0|0|tinyint|sys|tinyint|1|3|0||No|No|No||No||||||No|No|False|No|No|||
|Nombre|Nombre del tipo de documento.|No|No|No|No|0|0|varchar|sys|varchar|32|0|0|Latin1_General_CS_AS|No|Sí|No||No||||||No|No|False|No|No|||

## Índices

|Nombre|Nombre Automático|Deshabilitado|Llave Primaria|Tipo|Grupo De Archivos|Único|Pertenece A Una Restricción|Ignorar Llaves Duplicadas|Admite Bloqueos De Página|Admite Bloqueos De Fila|Factor De Llenado|Texto Completo|Objeto Del Sistema|Llenar Índice|No Recalcular|Particionado|Esquema De Partición|XML|Padre XML|Tipo De Índice XML Secundario|
|------|-----------------|-------------|--------------|----|-----------------|-----|---------------------------|-------------------------|-------------------------|-----------------------|-----------------|--------------|------------------|-------------|-------------|------------|--------------------|---|---------|-----------------------------|
|PK_TipoDocumentos|No|No|Sí|CLUSTERED|PRIMARY|Sí|No|No|Sí|Sí|0|No|No|No|No|No||No||0|

## Comando SQL

~~~sql
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [Repartos].[TipoDocumentos](
	[Id] [tinyint] NOT NULL,
	[Nombre] [varchar](32) COLLATE Latin1_General_CS_AS NOT NULL,
 CONSTRAINT [PK_TipoDocumentos] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'C�digo del tipo de documento.' , @level0type=N'SCHEMA',@level0name=N'Repartos', @level1type=N'TABLE',@level1name=N'TipoDocumentos', @level2type=N'COLUMN',@level2name=N'Id'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Nombre del tipo de documento.' , @level0type=N'SCHEMA',@level0name=N'Repartos', @level1type=N'TABLE',@level1name=N'TipoDocumentos', @level2type=N'COLUMN',@level2name=N'Nombre'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Almacena la informaci�n de los tipos de documentos.' , @level0type=N'SCHEMA',@level0name=N'Repartos', @level1type=N'TABLE',@level1name=N'TipoDocumentos'
GO
~~~


## Usada Por

[Repartos.Clientes](https://github.com/D200041/Repartos.git/wiki/Repartos.Clientes)

[Repartos.Repartidores](https://github.com/D200041/Repartos.git/wiki/Repartos.Repartidores)


## Depende De

