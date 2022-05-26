package com.example.tema1.controller;

/**
 * The type Event controller.
 */
/*@RestController
@RequestMapping("/events")
public class EventController {

    private static FilmService filmService;
    private static SpectacolService spectacolService;
    private static EventService eventService;

    /**
     * Instantiates a new Event controller.
     *
     * @param filmService      the film service
     * @param spectacolService the spectacol service
     * @param eventService     the event service
     */
    /*@Autowired
    public EventController(FilmService filmService, SpectacolService spectacolService, EventService eventService) {
        this.filmService = filmService;
        this.spectacolService = spectacolService;
        this.eventService = eventService;
    }

    /**
     * Insert film string.
     *
     * @param film the film
     * @return the string
     */
    /*@PostMapping("/insert/film")
    public String insertFilm(@RequestBody Film film){
        return filmService.save(film).toString();
    }

    /*@PostMapping("/insert/film/factory")
    public String insertFilmFactory(@RequestBody Film film, @RequestParam String f){
        EventFactory eventFactory = new EventFactory();
        Event event1 = film;
        film = (Film)eventFactory.createEvent(EventType.FILM, event1);

        return filmService.save(film).toString() + f;
    }*/

    /*@PostMapping("/insert/film/factory")
    public String insertFilmFactory(@RequestBody Event event){
        EventFactory eventFactory = new EventFactory();
        //Film film = (Film)event;
        Event event1 = event;

       // if(event instanceof Film){
            //Film film = (Film) event;
              //   event = eventFactory.createEvent(EventType.FILM, event);
            //Film event1 = (Film) event;
          //  event = (Film)eventFactory.createEvent(EventType.FILM, event1);
        event = eventFactory.createEvent(EventType.FILM, event1);
            return eventService.save(event).toString();
        //}
        //return null;
    }

    /**
     * Insert spectacol string.
     *
     * @param spectacol the spectacol
     * @return the string
     */
    /*@PostMapping("/insert/spectacol")
    public String insertSpectacol(@RequestBody Spectacol spectacol){
        return spectacolService.save(spectacol).toString();
    }

    /**
     * Insert spectacol factory string.
     * inseram spectacolul creat in clasa de Factory(EventFactory)
     * @param spectacol the spectacol
     * @return the string
     */
    /*@PostMapping("/insert/spectacol/factory")
    public String insertSpectacolFactory(@RequestBody Spectacol spectacol){
        EventFactory eventFactory = new EventFactory();
        spectacol = (Spectacol) eventFactory.createEvent(EventType.SPECTACOL);

        return spectacolService.save(spectacol).toString();
    }*/

    /**
     * Show events iterable.
     * afisam toate evenimentele din baza de date(filme, spectacole)
     * @return the iterable
     */
    /*@GetMapping("/all")
    public Iterable<Event> showEvents(){
        for(Event e: eventService.findAll()){
            System.out.println(e.toString());
        }
        return eventService.findAll();
    }

    /**
     * Show filme iterable.
     * afisam toate filmele din baza de date
     * @return the iterable
     */
    /*@GetMapping("/all/filme")
    public Iterable<Film> showFilme(){
        for(Event e: eventService.findAll()){
            if(e instanceof Film){
                System.out.println(e.toString());
            }
        }
        return filmService.findAll();
    }

    /**
     * Show spectacole iterable.
     * afisam toate spectacolele din baza de date
     * @return the iterable
     */
    /*@GetMapping("/all/spectacole")
    public Iterable<Spectacol> showSpectacole(){
        for(Event e: eventService.findAll()){
            if(e instanceof Spectacol){
                System.out.println(e.toString());
            }
        }
        return spectacolService.findAll();
    }

    /**
     * Gets film service.
     *
     * @return the film service
     */
   /* public static FilmService getFilmService() {
        return filmService;
    }

    /**
     * Sets film service.
     *
     * @param filmService the film service
     */
   /* public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    /**
     * Gets spectacol service.
     *
     * @return the spectacol service
     */
  /*  public static SpectacolService getSpectacolService() {
        return spectacolService;
    }


    /**
     * Sets spectacol service.
     *
     * @param spectacolService the spectacol service
     */
   /* public void setSpectacolService(SpectacolService spectacolService) {
        this.spectacolService = spectacolService;
    }

    /**
     * Gets event service.
     *
     * @return the event service
     */
    /*public static EventService getEventService() {
        return eventService;
    }

    /**
     * Sets event service.
     *
     * @param eventService the event service
     */
    /*public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}*/
