# virosa

| Version | Update Time | Status | Author | Description |
|---------|-------------|--------|--------|-------------|
|v2023-01-06 20:47:55|2023-01-06 20:47:55|auto|@wjl|Created by smart-doc|



## pin controller
### select all pins
**URL:** http://localhost:8088/pin/all

**Type:** GET

**Author:** <a href="mailto:wlonestar@163.com">wjl</a>

**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** select all pins

**Request-example:**
```
curl -X GET -i http://localhost:8088/pin/all
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|timestamp|int64|No comments found.|-|
|status|int32|No comments found.|-|
|message|string|No comments found.|-|
|data|object|No comments found.|-|

**Response-example:**
```
{
  "timestamp": 1673009276277,
  "status": 298,
  "message": "success",
  "data": {}
}
```

### select all pins by authorId
**URL:** http://localhost:8088/pin/all/author

**Type:** GET

**Author:** <a href="mailto:wlonestar@163.com">wjl</a>

**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** select all pins by authorId

**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|authorId|int64|true|authorId|-|

**Request-example:**
```
curl -X GET -i http://localhost:8088/pin/all/author?authorId=467 --data '&467'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|timestamp|int64|No comments found.|-|
|status|int32|No comments found.|-|
|message|string|No comments found.|-|
|data|object|No comments found.|-|

**Response-example:**
```
{
  "timestamp": 1673009276277,
  "status": 642,
  "message": "success",
  "data": {}
}
```

### select all pins by page
**URL:** http://localhost:8088/pin/page

**Type:** GET

**Author:** <a href="mailto:wlonestar@163.com">wjl</a>

**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** select all pins by page

**Request-example:**
```
curl -X GET -i http://localhost:8088/pin/page
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|timestamp|int64|No comments found.|-|
|status|int32|No comments found.|-|
|message|string|No comments found.|-|
|data|object|No comments found.|-|

**Response-example:**
```
{
  "timestamp": 1673009276277,
  "status": 178,
  "message": "success",
  "data": {}
}
```

### select all pins by page and by authorId
**URL:** http://localhost:8088/pin/page/author

**Type:** GET

**Author:** <a href="mailto:wlonestar@163.com">wjl</a>

**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** select all pins by page and by authorId

**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|authorId|int64|true|authorId|-|

**Request-example:**
```
curl -X GET -i http://localhost:8088/pin/page/author?authorId=921 --data '&921'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|timestamp|int64|No comments found.|-|
|status|int32|No comments found.|-|
|message|string|No comments found.|-|
|data|object|No comments found.|-|

**Response-example:**
```
{
  "timestamp": 1673009276277,
  "status": 445,
  "message": "success",
  "data": {}
}
```

### select pin by id
**URL:** http://localhost:8088/pin/single

**Type:** GET

**Author:** <a href="mailto:wlonestar@163.com">wjl</a>

**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** select pin by id

**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int64|true|id|-|

**Request-example:**
```
curl -X GET -i http://localhost:8088/pin/single?id=909 --data '&909'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|timestamp|int64|No comments found.|-|
|status|int32|No comments found.|-|
|message|string|No comments found.|-|
|data|object|No comments found.|-|

**Response-example:**
```
{
  "timestamp": 1673009276277,
  "status": 452,
  "message": "success",
  "data": {}
}
```


