oauth2 请求路径
```$xslt
curl -X POST -vu clientapp:123456 http://localhost:8081/oauth/token -H "Accept: application/json" -d "password=admin&username=admin&grant_type=password&scope=read%20write&client_secret=123456&client_id=clientapp"

```