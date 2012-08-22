DECLARE @old sysname, @new sysname, @sql nvarchar(1000)

SELECT
  @old = 'oldOwner_CHANGE_THIS'
  , @new = 'dbo'
  , @sql = '
  IF EXISTS (SELECT NULL FROM INFORMATION_SCHEMA.TABLES
  WHERE
      QUOTENAME(TABLE_SCHEMA)+''.''+QUOTENAME(TABLE_NAME) = ''?''
      AND TABLE_SCHEMA = ''' + @old + '''
  )
  EXECUTE sp_changeobjectowner ''?'', ''' + @new + ''''

EXECUTE sp_MSforeachtable @sql
GO
