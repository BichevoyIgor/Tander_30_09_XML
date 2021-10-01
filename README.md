На основании запроса
SELECT ID_ART,NAME,CODE,USERNAME,GUID FROM WHS.ARTICLE where rownum < 10000
Сформировать XML вида :
```
<articles>
       <articles id_art="104880" name="Батон нарезной в/с 0.4кг" code="1010050114" username="WHS" guid="6992B998083711DC87F900093D12899D">
    ...
</articles>
```
