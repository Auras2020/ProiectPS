package com.example.tema1;

import com.example.tema1.model.*;
import com.example.tema1.repo.*;
import com.example.tema1.service.*;
//import com.example.tema1.service.FilmService;
//import com.example.tema1.service.SpectacolService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Scanner;

/**
 * The type Tema 1 application.
 */
@SpringBootApplication
public class Tema1Application {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Tema1Application.class, args);
    }

    /*@Bean
    public CommandLineRunner run(AngajatRepository angajatRepository, ClientRepository clientRepository,
                                 FilmRepository filmRepository, SpectacolRepository spectacolRepository,
                                 VanzatorRepository vanzatorRepository){
        //return (args -> {
            int oraStart = 0;
            for(Vanzator v: vanzatorRepository.findAll()){
                if(v.getInterval_orar().length()==4){
                    oraStart = Integer.parseInt(v.getInterval_orar().substring(0, 1));
                }
                else{
                    oraStart = Integer.parseInt(v.getInterval_orar().substring(0, 2));
                }
                System.out.println(oraStart);
            }
            if(angajatRepository.count()==0) {
                insertAngajat(angajatRepository);
                insertClients(clientRepository);
                insertFilm(filmRepository);
                insertSpectacol(spectacolRepository);
                insertVanzator(vanzatorRepository);
            }
            //System.out.println(clientRepository.findAll());
        });
    }*/

    /*public void insertAngajat(AngajatRepository angajatRepository){
        angajatRepository.save(new Angajat("Paul", "12-20", 1, "paul2022", "2022paul"));
        angajatRepository.save(new Angajat("Mircea", "8-12", 2, "mircea2022", "2022mircea"));
        angajatRepository.save(new Angajat("Marc", "20-24", 3, "marc2022", "2022marc"));
       /* angajatRepository.save(new Angajat("Sandu", "8-12", 4));
        angajatRepository.save(new Angajat("Andrei", "12-20", 5));
        angajatRepository.save(new Angajat("Ana", "12-20", 6));
        angajatRepository.save(new Angajat("Mircea", "20-24", 7));
        angajatRepository.save(new Angajat("Dan", "8-12", 8));
        angajatRepository.save(new Angajat("Gigel", "20-24", 9));
    }*/

    /*private void insertClients(ClientRepository clientRepository){
        clientRepository.save(new Client("Andrei", 21, "DA", "andrei2022", "2022andrei"));
        clientRepository.save(new Client("Ana", 17, "NU", "ana2022", "2022ana"));
        clientRepository.save(new Client("Ana", 14, "DA", "ana2022", "2022ana"));
        clientRepository.save(new Client("Matei", 12, "NU", "matei2022", "2022matei"));
        clientRepository.save(new Client("Marius", 8, "DA", "marius2022", "2022marius"));
        clientRepository.save(new Client("Darius", 19, "DA", "darius2022", "2022darius"));
        clientRepository.save(new Client("Raul", 27, "DA", "raul2022", "2022raul"));
        clientRepository.save(new Client("Catalin", 13, "DA", "catalin2022", "2022catalin"));
        clientRepository.save(new Client("Vasile", 33, "DA", "vasile2022", "2022vasile"));
        clientRepository.save(new Client("Bogdan", 65, "DA", "bogdan2022", "2022bogdan"));
    }

    private void insertFilm(FilmRepository filmRepository){
        filmRepository.save(new Film("Aftermath", "horror", 15, "simplu", "12:15 06-04-2020 Mi", 34, 18, "Peter Winther",
                "Ashley Greene, Shawn Ashmo, Jason Liles", new HashSet<>()));
        filmRepository.save(new Film("Amar", "drama", 12, "premiera", "22:30 12-10-2021 V", 56, 25, "Pol Monta",
                "Maria Pedraza, Sonia Almarcha, Greta Fernand", new HashSet<>()));
        filmRepository.save(new Film("Avengers", "actiune", 12, "avanpremiera", "20:30 12-03-2020 L", 50, 26,
                "Joss Whedon", "Scarlett Johanson, Robert Downey, Chris Evans", new HashSet<>()));
        filmRepository.save(new Film("Baghul", "horror", 21, "premiera", "14:55 04-08-2021 J", 75, 25, "Scott Derickson",
                "Ethan Hawke, James Ranson, Clare Foley", new HashSet<>()));
        filmRepository.save(new Film("Infinite", "actiune", 18, "simplu", "11:12 13-03-2021 S", 21, 22, "Antoine Fuqua",
                "Mark Walhberg, Chris Evans, Dylan O'Brien", new HashSet<>()));
        filmRepository.save(new Film("King", "drama", 15, "avanpremiera", "16:45 21-07-2020 S", 87, 28, "David Michord",
                "Robert Patinson, Joel Edgerton", new HashSet<>()));
        filmRepository.save(new Film("Liar", "comedie", 12, "premiera", "20:45 14-12-2021 D", 34, 26, "James Strong",
                "Ioan Gruffudd, Shelley Conn", new HashSet<>()));
        filmRepository.save(new Film("Nun", "horror", 18, "avanpremiera", "23:15 21-09-2021 V", 78, 30, "Corin Hardy",
                "Taisa Framiga, Vera Farmiga, Patrick Wilson", new HashSet<>()));
        filmRepository.save(new Film("Spiderman", "comedie", 12, "premiera", "10:15 23-12-2020 Ma", 35, 22, "John Wats",
                "Jamie Fox, Benedict Cumdum, Tom Holland", new HashSet<>()));
        filmRepository.save(new Film("Terminator", "actiune", 15, "simplu", "21:15 23-07-2021 Mi", 67, 20, "Tim Miller",
                "Arnold Schwarzeneger, Linda Hamilton", new HashSet<>()));
    }

    public void insertSpectacol(SpectacolRepository spectacolRepository){
        spectacolRepository.save(new Spectacol("Aievea", "populara", "09-12-2021", 15, "Andra", "20-22"));
        spectacolRepository.save(new Spectacol("Concert Arenele Romane", "electro", "12-05-2021", 25, "Kraftwerk", "19-20"));
        spectacolRepository.save(new Spectacol("Crazy Rock", "rap", "21-03-2021", 20, "Confessions", "12-18"));
        spectacolRepository.save(new Spectacol("Emerald Island", "pop", "09-08-2020", 18, "Caro Emerald", "21-24"));
        spectacolRepository.save(new Spectacol("Foreigner", "rock", "06-12-2021", 31, "Bone Man", "16-19"));
    }

    public void insertVanzator(VanzatorRepository vanzatorRepository){
        vanzatorRepository.save(new Vanzator("George", "8-12", 1, "george2022", "2022george"));
        vanzatorRepository.save(new Vanzator("Matei", "12-20", 2, "matei2022", "2022matei"));
        vanzatorRepository.save(new Vanzator("Nan", "8-12", 3, "nan2022", "2022nan"));
        vanzatorRepository.save(new Vanzator("Horia", "20-24", 4, "horia2022", "2022horia"));
        vanzatorRepository.save(new Vanzator("Gigel", "12-20", 5, "gigel2022", "2022horia"));
        vanzatorRepository.save(new Vanzator("Andrei", "8-12", 6, "andrei2022", "2022andrei"));
        vanzatorRepository.save(new Vanzator("Andrei", "20-24", 7, "andrei2022", "2022andrei"));
        vanzatorRepository.save(new Vanzator("Bogdan", "20-24", 8, "bogdan2022", "2022bogdan"));
        vanzatorRepository.save(new Vanzator("Bogdan", "12-20", 9, "bogdan2022", "2022bogdan"));
    }*/
}


