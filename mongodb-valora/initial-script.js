let instructions = [
    db.vendors.drop(),
    db.vendors.insert({
        "_id":"greydoor",
        "name":"Grey Door Hotel",
        "url":"grey-door:9003"
    }),
    db.vendors.insert({
        "_id":"bluedoor",
        "name":"Blue Door Hotel",
        "url":"blue-door:9002"
    })
];

instructions.forEach(function(instruction) {
    printjson(instruction);
});
