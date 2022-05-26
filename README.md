# ProiectPS

## Tema proiectului

&nbsp;    Tema proiectului este "Platforma de ticketing pentru filme si spectacole". In cadrul acestui proiect, mi-am propus sa am o lista de clienti care vor trebui sa se logeze in aplicatie pentru a putea accesa lista de evenimente disponibile. In aplicatie vor mai exista de asemenea angajati si vanzatori; vanzatorii vor crea bilete pentru clientii care indeplinesc conditiile necesare pentru a intra la un eveniment(varsta, certificatul verde), iar angajatii vor confirma crearea unui bilet pentru un anumit client.

## Descriere proiect

&nbsp;    In cadrul acestui proiect am pachete model, controller, repo, service si test.

&nbsp;    In pachetul de model am clasele care definesc tabelele din baza de date(Angajat, Client, Vanzator, Film, Spectacol), clasele User si Event mostenite de cele din urma, clasa Bilet folosita pentru a salva evenimentul la care participa un client pe baza id-ului evenimentului si al clientului; de asemenea, se va genera un numar al biletului care este reprezentat de numarul evenimentului generat. Avem clase de EventModelFactory si UserModelFactory in cadrul carora ne vom folosi de design patternul Factory pentru as ne crea instante de evenimente si useri, pe acestia din urma inserandu-i in baza de date.

&nbsp;    In pachetul repo avem insiruite interfetele de tip CrudRepository care realizeaza operatiile de tip "CRUD" in baza de date(create, read, update, delete) asupra unor obiecte.

&nbsp;    In pachetul service imi definesc in cadrul unor interfete principalele metode folosite pentru interogarea bazei de date, pe care le voi implementa in cadrul unor clase de Service. In corpul metodelor implementate voi apela metodele existente din interfele de tip "CRUD", iar instanta de interfata CRUD va fi declarata ca un field final pentru a nu putea fi modificata accidental. 

&nbsp;    In pachetul controller mi-am creat metode in cadrul carora apelez metodele din pachetul de service si leg metodele din pachetul de controller de logica aplicatiei prin adnotatii de tip mapping(GetMapping, PostMapping) la care mentionez si linkul catre pagina web care doresc sa mi se deschida cand este apelata metoda.
`  

&nbsp;    In pachetul de test ma folosesc de anumite adnotatii(Test, BeforeEach, Mock) cu ajutorul carora testez functionalitatea metodelor implementate in celelalte pachete. In cadrul acestor metode se apeleaza alte metode predefinite in java, precum "assertEquals", care compara rezultatul asteptat cu cel obtinut, sau "verify", care verifica daca o metoda s-a executat cu succes. 

&nbsp;    In cadrul acestei teme am implementat design patternul Factory, am efectuat testari unitare, am generat javadocul, am facut diagrama uml si cea de baze de date si am finalizat endpoint-urile. 
   
## Factory Pattern   
   
&nbsp;     Pentru Factory Pattern mi-am creat initial 2 enum-uri(EventType si UserType) pe care le-am folosit pentru a identifica tipul clasei pe care vrem sa o cream. Astfel, mi-am creat 2 clase(EventFactory si UserFactory) in cadrul carora imi creez instante de diferite obiecte mostenite dintr-o clasa abstracta. Aceste obiecte create si returnate in cadrul claselor Factory vor fi folosite in clasele Controller pentru a fi inserate in baza de date. Tot factory am utilizat si in clasele de controller, unde mi-am instantiat in cadrul constructorului un obiect de tip service, care decide ce fel de eveniment sau user sa creeze.

![1](https://user-images.githubusercontent.com/72803005/167927107-407a38a4-22b3-4a4e-b56d-9695e0dd8474.png)

![2](https://user-images.githubusercontent.com/72803005/167927117-fe9844bd-afaf-418e-8bca-c6843f68615c.png)

## Diagrama baza de date

&nbsp;    La diagrama de baze de date se pot observa relatii one-to many intre tabelele film-bilete_filme, bilete_filme-client, client-bilete_spectacole, bilete_spectacole-spectacol. Tabelele bilete_film si bilete_spectacole au fost create automat de spring si au rolul de a retine biletele vandute in baza de date. Fara aceste tabele ar fi existat relatii many-to-many intre tabele client-film si client-spectacol. 


![diagrama_baza_de_date](https://user-images.githubusercontent.com/72803005/167926505-b1b0aa1c-ceb7-4440-8a19-e9036aaca635.png)


## Diagrama UML

&nbsp;    La digarma uml exista relatii de mostenire(clasele Film si Spectacol mostenesc clasa Eveniment), asociere(intre interfetele Repository si clasele de tip model, care este de fapt parametru al interfetei CrudRepository), implementare(Clasa ClientService implementeaza interfata IClientService), dependenta(o clasa de factory creeaza instante de tip service), compozitie(intre BiletController si BiletService, deoarece exista o legatura foarte stransa intre cele doua, clasa BiletService fiind instantiata in clasa BiletController). 


![uml](https://user-images.githubusercontent.com/72803005/167926683-55ec4b35-d8ff-4ba5-8f5e-33533931f431.png)


## Teste unitare

&nbsp;    La testele unitare testez efectiv fiecare metoda creata. In pachetul de test exista pachete de tip repo, service si controller, aferente pachetelor in care se afla metodele testate. In cadrul fiecarui astfel de pachet exista clase aferente claselor in care se afla metodele testate, iar metodele sunt semnalate ca a fi folosite pentru testarea unitara cu adnotatii precum Test, BeforeEach si Mock. De exemplu, pentru a verifica daca s-au inserat cu succes obiectele salvate in baza de date. Verificam acest aspect prin compararea user-ului sau a evenimentului aflat la un id la care ar trebui sa se afle in urma inserarii(ultimul introdus in baza de date) cu un user sau un eveniment pe care ne asteptam sa il avem(cel pe care l-am creat prin intermediul design pattern-ului Factory). 

![1](https://user-images.githubusercontent.com/72803005/167927397-ea72a236-2ed9-48b1-b85e-c1ad1da9366b.png)

![2](https://user-images.githubusercontent.com/72803005/167927432-771b8205-160c-4b89-838e-7202c072f60a.png)

 
 ## Frontend
 
 &nbsp;    Partea de frontend a fost realizata in kotlin android; interfata utilizator a fost realizata in principiu in cadrul unor fisiere xml, in cadrul carora au
 fost incluse principalele componente ale unei pagini android(butoane, textview-uri, edittext-uri, imageview-uri, recycleview-uri). In kotlin este proiectata legatura
 dintre partea de frontend si cea de backend din cadrul proiectului.
 
 &nbsp;   Atunci cand rulam aplicatia pagina principala care se deschide contine o imagine sugestiva a temei proiectului in partea de sus a paginii, iar in partea inferioara
 imagini si butoane de login pentru fiecare user(admin, client, vanzator si angajat). 
 
 ![1](https://user-images.githubusercontent.com/72803005/170584128-439c6e19-3c59-4e1d-aaf1-1fc8e751f2bc.png)
 
 &nbsp;   Fiecare user se va loga in aplicatie cu ajutorul username-ului si al unei parole(EditText-uri). La admin un username valid are cel putin 3 caractere, iar o parola 
 valida are cel putin 5 caractere. La ceilalti useri numele de utilizator si parola trebuie sa se regaseasca in baza de date pentru a fi valide. 

![1](https://user-images.githubusercontent.com/72803005/170584607-a89a9339-c1e0-415d-8d01-5e7d5b28e7bb.png)

&nbsp;    Dupa ce se va putea loga in aplicatie, admin-ul va putea selecta meniul pentru filme sau cel pentru spectacole, dar si butonul de logout pentru a iesi din aplicatie.
In cadrul meniului de filme, dar si a celui de spectacole admin-ul va putea selecta optiunile de adaugare, actualizare, stergere, respectiv vizualizare de evenimente
(poate efectua operatii CRUD asupra bazei de date). In cadrul acestei pagini admin-ul va mai putea sa se reintoarca la pagina precedenta sau sa se delogeze din aplicatie.
La optiunile de adaugare, actualizare si stergere admin-ul va trebui sa introduca informatii valide despre evenimentul pe care doreste sa il prelucreze, altfel vor fi
afisate mesaje de eroare sugestive in cadrul EditText-ului respectiv. Daca admin-ul nu mai doreste sa prelucreze un eveniment, atunci se poate intoarce la pagina precedenta.

&nbsp;    In cadrul paginii pentru client putem vedea optiunile de rezervare bilet film/spectacol, respectiv vizualizare film/spectacol, in cazul in care clientul nu stie
ce evenimente sunt disponibile in momentul actual si doreste sa le vizualizeze inainte de a face o rezervare. Pentru a rezerva un eveniment, clientul trebuie doar sa
introduca numele evenimentului, iar in cazul in care acesta nu exista in baza de date se va afisa un mesaj de eroare sugestiv, altfel se va iesi din pagina de rezervare
eveniment si va fi creat un bilet pentru client, afisandu-se un mesaj scurt de confirmare. In caz ca nu mai doreste sa faca nicio rezervare si nici sa vizualizeze 
evenimentele curente clientul se poate deloga din aplicatie.

&nbsp;    Dupa ce se logeaza in aplicatie, vanzatorul poate vedea incasarile inregistrate pentru filme si spectacole, dar si cele totale reprezentate ca suma dintre 
incasarile filmelor si a spectacolelor. Dupa ce vizualizeaza aceste informatii, vanzatorul se poate deloga din aplicatie.

![image](https://user-images.githubusercontent.com/72803005/170587384-d85fd72e-164c-4895-80a2-bf3a8b9077fc.png)

&nbsp;    Dupa ce se logeaza in aplicatie, angajatul poate vedea toate biletele cumparate pana in momentul actual; biletele contin informatii precum numarul acestora,
numele clientului care l-a cumparat si numele evenimentului la care a rezervat bilet clientul respectiv. Dupa ce vizualizeaza aceste informatii, angajatul se poate deloga din aplicatie.

![1](https://user-images.githubusercontent.com/72803005/170587311-0172e806-2cf6-49ee-b4b0-9ddafd0d1d96.png)

 ## Realizarea legaturii dintre Frontend si Backend
 
 &nbsp;    Se porneste initial de la la crearea unui data class care contine exact numele coloanelor din cadrul unei tabele din baza de date sau field-urile unei clase
 model din backend. Operatiile CRUD care vor fi efectuate sunt definite in cadrul unor interfete in kotlin, cu adnotatii similare cu cele din controller-ul claselor
 din java spring, fiecare primind ca parametru un endpoint.
 
 ![1](https://user-images.githubusercontent.com/72803005/170590664-7d83d375-9984-46ec-bd90-b5dd5e627fc2.png) ![1](https://user-images.githubusercontent.com/72803005/170590720-1bdb4782-31c0-418b-8f7b-6a0373e35ed0.png)


 
 &nbsp;    In continuare am utilizat clase de tip Adapter pentru a defini aspectul datelor afisate in cadrul unui RecyclerView. 
 
 &nbsp;    Principalul element care permite realizarea legaturii cu partea de backend o constituie metodele apelate din cadrul clasei predefinite Retrofit, la care trebuie
 specificate url-ul de baza(portul http urmat de adresa ipv4 si codul 8080) si interfata pe baza careia realizam legatura cu un element din backend. Dupa ce apelam 
 metoda definita in cadrul interfetei respective vom putea avea toate datele necesare stocate intr-o singura variabila, dupa care vom crea o instanta de tipul 
 recyclerview si una de tip adapter care va primi ca parametru lista de elemente obtinuta, in urma caruia se va afisa intr-un astfel de recyclerview o lista de 
 view-uri continand elemente din cadrul listei create anterior. Lista respectiva va fi modificata de fiecare data cand se vor efectua operatii de prelucrare(inserare,
 stergere, actualizare). 
 
 ![1](https://user-images.githubusercontent.com/72803005/170590577-99261738-6554-4dda-a063-5e36c8e3c7db.png)

 
 



