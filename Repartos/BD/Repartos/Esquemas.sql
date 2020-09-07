USE "Repartos";
GO

CREATE SCHEMA "Repartos";
GO

EXECUTE "sys"."sp_addextendedproperty"
	@name = N'MS_Description',
	@value = N'Esquema que agrupa los objetos para la aplicación de repartos.',
	@level0type = N'SCHEMA',
	@level0name = N'Repartos';
GO