print("--- Started database creation process ---");

db = db.getSiblingDB("vgl");
db.createUser(
    {
        user: "vgl_user",
        pwd: "vgl_pass",
        roles: [{role: "readWrite", db: "vgl"}]
    }
);
db.createCollection("vehicle_location");

print("--- Database creation process completed ---");
