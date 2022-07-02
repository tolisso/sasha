# tolisso-sasha
Easy to install webpages screenshot service.

# Install and Run
* Install docker
* download [docker-compose.yaml](https://github.com/tolisso/sasha/blob/master/docker-compose.yaml) file
* run `docker compose up` in directory with downloaded file

# Usage
Request example: http://localhost:2007/screenshot?width=1000&height=6000&timeout=0&url=https://docs.docker.com/engine/install/ubuntu/

After launch, on your localhost:2007 will be deployed server. To get screenshot make GET request on /screenshot page. 

Parameters are:
- width
- height
- timeout - seconds between load of webpage and screenshot, may be fractional
- url - url of webpage to make screenshot

# Stop Service
Use `Ctrl+C` or run `docker compose down`

# Additional
You can change port of server if you change environment variable `SASHA_PORT` to corresponding value before running the service. 
If you had already ran service it is recommended to make `docker compose down` before next launch.

Example for windows: `SET SASHA_PORT=1883` \
Example for linux: `export SASHA_PORT=1883`
