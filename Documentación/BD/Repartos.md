## Descripción

Esquema que agrupa los objetos para la aplicaci�n de repartos.

## Propiedades

|Propiedad|Valor|
|---------|-----|
|Propietario|dbo|

## Comando SQL

~~~sql
CREATE SCHEMA [Repartos]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Esquema que agrupa los objetos para la aplicaci�n de repartos.' , @level0type=N'SCHEMA',@level0name=N'Repartos'
GO
~~~

