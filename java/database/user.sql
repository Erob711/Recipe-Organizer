-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER recipe_organizer_owner
WITH PASSWORD 'recipeorganizer';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO recipe_organizer_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO recipe_organizer_owner;

CREATE USER recipe_organizer_appuser
WITH PASSWORD 'recipeorganizer';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO recipe_organizer_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO recipe_organizer_appuser;
