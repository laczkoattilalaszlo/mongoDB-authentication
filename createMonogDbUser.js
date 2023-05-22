// Connect and authenticate to admin database (which is the authentication database) with an admin user.
const connection = new Mongo();
const adminDB = connection.getDB("admin");
adminDB.auth("adminUserName", "adminPassword");

// Create a new user
const testDB = connection.getDB("testDB");
testDB.createUser({ user: 'testUserName', pwd: 'testPassword', roles: ['readWrite']})
