#!/usr/bin/env bash
docker rm wallet
docker run --name wallet -p 8082:8080 -d -t atghackathon/wallet

