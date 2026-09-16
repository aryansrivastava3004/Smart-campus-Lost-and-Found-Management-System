# Test Cases

| ID | Test | Expected Result |
|---|---|---|
| TC01 | Register valid student | Student gets ID |
| TC02 | Blank name | Validation error |
| TC03 | Invalid email | Validation error |
| TC04 | Add lost item | Record stored |
| TC05 | Add found item | Record stored |
| TC06 | Search keyword | Matching records shown |
| TC07 | Possible match | Score >= 50% shown |
| TC08 | Submit claim | PENDING claim created |
| TC09 | Approve claim | Item becomes CLAIMED |
| TC10 | Backup | CSV created |
| TC11 | Restart app | Records persist |
