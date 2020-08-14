let instructions = [
    db.rooms.drop(),
    db.rooms.insert({
        "_id":"BD001",
        "type":"single",
        "status":"available"
    }),
    // db.rooms.insert({
    //     "_id":"BD002",
    //     "type":"single",
    //     "status":"available"
    // }),
    // db.rooms.insert({
    //     "_id":"BD003",
    //     "type":"single",
    //     "status":"available"
    // }),
    // db.rooms.insert({
    //     "_id":"BD004",
    //     "type":"single",
    //     "status":"available"
    // }),
    // db.rooms.insert({
    //     "_id":"BD005",
    //     "type":"single",
    //     "status":"available"
    // }),
    // db.rooms.insert({
    //     "_id":"BD006",
    //     "type":"double",
    //     "status":"available"
    // }),
    // db.rooms.insert({
    //     "_id":"BD007",
    //     "type":"double",
    //     "status":"available"
    // }),
    // db.rooms.insert({
    //     "_id":"BD008",
    //     "type":"double",
    //     "status":"available"
    // }),
    // db.rooms.insert({
    //     "_id":"BD009",
    //     "type":"double",
    //     "status":"available"
    // }),
    db.rooms.insert({
        "_id":"BD010",
        "type":"double",
        "status":"available"
    })
];

instructions.forEach(function(instruction) {
    printjson(instruction);
});
