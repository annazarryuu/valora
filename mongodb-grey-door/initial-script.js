let instructions = [
    db.rooms.drop(),
    db.rooms.insert({
        "_id":"GD001",
        "type":"single",
        "status":"available"
    }),
    // db.rooms.insert({
    //     "_id":"GD002",
    //     "type":"single",
    //     "status":"available"
    // }),
    // db.rooms.insert({
    //     "_id":"GD003",
    //     "type":"single",
    //     "status":"available"
    // }),
    // db.rooms.insert({
    //     "_id":"GD004",
    //     "type":"single",
    //     "status":"available"
    // }),
    // db.rooms.insert({
    //     "_id":"GD005",
    //     "type":"single",
    //     "status":"available"
    // }),
    // db.rooms.insert({
    //     "_id":"GD006",
    //     "type":"double",
    //     "status":"available"
    // }),
    // db.rooms.insert({
    //     "_id":"GD007",
    //     "type":"double",
    //     "status":"available"
    // }),
    // db.rooms.insert({
    //     "_id":"GD008",
    //     "type":"double",
    //     "status":"available"
    // }),
    // db.rooms.insert({
    //     "_id":"GD009",
    //     "type":"double",
    //     "status":"available"
    // }),
    db.rooms.insert({
        "_id":"GD010",
        "type":"double",
        "status":"available"
    })
];

instructions.forEach(function(instruction) {
    printjson(instruction);
});
