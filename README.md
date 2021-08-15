# op.gg-update-8-15
챔피언 숙련도 보여주기 기능추가
<img width="473" alt="스크린샷 2021-08-15 오후 4 28 14" src="https://user-images.githubusercontent.com/69393030/129470615-67de9661-8109-4f53-9f7b-1b44ebcfdd1b.png">
검색한 , 해당소환사의 챔피언 숙련도를 보여주는 기능입니다.
# 사용 
<img width="1001" alt="스크린샷 2021-08-15 오후 4 28 57" src="https://user-images.githubusercontent.com/69393030/129470637-5a2b71c2-21cd-4b75-87be-f8fe414e8db0.png">
버튼을 클릭하면 해당소환사의 챔피언 숙련도 데이터를 가져옵니다. 
# server 
<img width="1001" alt="스크린샷 2021-08-15 오후 4 29 36" src="https://user-images.githubusercontent.com/69393030/129470657-0f1cb1cd-18e6-4ad5-bebd-7fb02c8830ad.png">
api 호출시 return 데이터는 jsonArray 이므로 , Type type = new TypeToken<List<?>>(){}.getType(); 을 사용하여 해당 데이터의 제네릭을 유추합니다. 
# client 
<img width="622" alt="스크린샷 2021-08-15 오후 4 30 29" src="https://user-images.githubusercontent.com/69393030/129470691-f9c792a1-e027-4188-8064-a74ece4ef26e.png">
호출하고나서 해당 데이터를 렌더링합니다. 
