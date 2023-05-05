BEGIN TRANSACTION;

DROP TABLE IF EXISTS photos;
DROP TABLE IF EXISTS notes;
DROP TABLE IF EXISTS instructions;
DROP TABLE IF EXISTS ingredients;
DROP TABLE IF EXISTS recipes;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE recipes (
    recipe_id SERIAL,
	user_id INT NOT NULL,
    title varchar(100) NOT NULL UNIQUE,
    category varchar(100) NOT NULL,

    CONSTRAINT PK_recipe PRIMARY KEY (recipe_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE ingredients (
    ingredient_id SERIAL,
    recipe_id INT NOT NULL,
    ingredient varchar(500) NOT NULL,
    ingredient_number INT NOT NULL,

    CONSTRAINT PK_ingredient_id PRIMARY KEY (ingredient_id),
    CONSTRAINT FK_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipes(recipe_id)
);

CREATE TABLE instructions (
    instruction_id SERIAL,
    recipe_id INT NOT NULL,
    instruction varchar(6000),
    instruction_number INT NOT NULL,

    CONSTRAINT PK_instruction_id PRIMARY KEY (instruction_id),
    CONSTRAINT FK_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipes(recipe_id)
);

CREATE TABLE notes (
    note_id SERIAL,
    recipe_id INT NOT NULL,
    note varchar(6000),

    CONSTRAINT PK_note_id PRIMARY KEY (note_id),
    CONSTRAINT FK_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipes(recipe_id)
);

CREATE TABLE photos(
    photo_id SERIAL,
    recipe_id INT NOT NULL,
    photo_url varchar(1000),

    CONSTRAINT PK_photo_id PRIMARY KEY (photo_id),
    CONSTRAINT FK_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipes(recipe_id)
);

COMMIT TRANSACTION;
