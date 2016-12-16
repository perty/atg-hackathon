#!/usr/bin/env bash
docker rm betting
docker run --name betting -p 8081:8080 -d -t atghackathon/betting
