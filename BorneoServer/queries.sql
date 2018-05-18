/* Initial script to create the table */
CREATE TABLE category (
  id IDENTITY, /* Auto incremented with annotation in entity class */
  name VARCHAR(50),
  description VARCHAR(255),
  image_url VARCHAR(50),
  is_active BOOLEAN,

  CONSTRAINT pk_category_id PRIMARY KEY (id) /* Constraint for the ID of the
  identity */
)