CREATE TABLE grownstate (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  table_name varchar(255) NOT NULL DEFAULT '',
  last_download datetime NOT NULL,
  download_hours int(11) NOT NULL,
  PRIMARY KEY (id)
);
