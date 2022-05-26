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
