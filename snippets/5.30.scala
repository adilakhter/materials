@ retry(max = 5){
    // Only succeeds with a 200 response code 1/3 of the time
    requests.get("https://httpbin.org/status/200,400,500")
  }
call failed, retrying #1
call failed, retrying #2
res40: requests.Response = Response(
  "https://httpbin.org/status/200,400,500",
  200,
...
