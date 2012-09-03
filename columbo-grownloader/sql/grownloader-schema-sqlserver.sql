CREATE TABLE GROWNSTATE (
  id bigint NOT NULL IDENTITY(1, 1),
  table_name nvarchar(255) NOT NULL DEFAULT '',
  last_download datetime NOT NULL,
  download_hours integer NOT NULL,
  PRIMARY KEY (id)
);
