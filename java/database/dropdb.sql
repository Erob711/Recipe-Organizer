-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'recipe_organizer';

DROP DATABASE recipe_organizer;

DROP USER recipe_organizer_owner;
DROP USER recipe_organizer_appuser;
