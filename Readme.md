# Crypto Currency Trader App

This app is DEMO Crypto Trader if you want to try how trading works but you don't want to use your real money yet.

## Quick Start
```
git clone https://github.com/Macilaci91/CryptoTrader.git
cd ./CryptoTrader
docker-compose-up
```

## How to use
```
First thing you should do! Update crypto values:
localhost:8087/update

If you want to view currencies value use:
localhost:8087/getCryptoAll

If you want to view your wallet use:
localhost:8087/getWallettAll

If you want to buy a currency use:
localhost:8087/buy?name=(here you write the crypto name)&amount=(amount you want to buy)
example: localhost:8087/buy?name=XRP&amount=1000

sell crypto:
localhost:8087/sell?name=(here you write the crypto name)&amount=(amount you want to sell)
example: localhost:8087/buy?name=XRP&amount=500
```
