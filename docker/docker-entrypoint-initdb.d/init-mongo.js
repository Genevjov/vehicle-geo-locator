db.createUser(
    {
        user: "root1",
        pwd: "example",
        roles: [
            {
                role: "readWrite",
                db: "vgl"
            }
        ]
    }
);
