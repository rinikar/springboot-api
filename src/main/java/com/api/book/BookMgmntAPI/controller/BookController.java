package com.api.book.BookMgmntAPI.controller;

import com.api.book.BookMgmntAPI.model.Book;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private com.api.book.BookMgmntAPI.services.bookservices bookservices;

	/*@GetMapping("/book")
	public List<Book> getAllBooks() {
	    return bookservices.findAll();
	}*/

	@PostMapping("/book")
	@ResponseStatus(HttpStatus.CREATED)
	public Book createBook(@RequestBody Book book) {
		return bookservices.addbook(book);
	}


	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable(value = "id") String bookId) {
		return bookservices.findById(bookId);
	}


	@PutMapping("/book/{id}")
	public Book updateBook(@PathVariable(value = "id") String bookId,
						   @RequestBody Book bookDetails) {
		bookservices.findById(bookId);
		bookDetails.setBookId(bookId);
		return bookservices.updatebook(bookDetails);
	}

	@DeleteMapping("/book/{bookId}")
	public String deleteBook(@PathVariable String bookId) {
		return bookservices.delById(bookId);
	}

	@GetMapping("/timezone-current-time")
	public String getCurrentTime(@RequestParam(value = "timeZone") List<String> timeZones) throws JSONException {
        StringBuilder response = new StringBuilder();
        for (String timeZone : timeZones) {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://www.timeapi.io/api/Time/current/zone?timeZone=" + timeZone;
            String jsonString = restTemplate.getForObject(apiUrl, String.class);
            JSONObject json = new JSONObject(jsonString);
            response.append(json.toString(4));
        }
        return response.toString();
    }

     @GetMapping("/convert")
    public DateTime convertTime(@RequestParam("from") String fromTimezone, @RequestParam("to") String toTimezone) {
        // Get the current time in the "from" timezone
        DateTime fromTime = new DateTime(DateTimeZone.forID(fromTimezone));

        // Get the current time in the "to" timezone based on the "from" time

		 return fromTime.withZone(DateTimeZone.forID(toTimezone));
    }


/*
     @GetMapping("/time-in-timezone")
    public ResponseEntity<String> getTimeInTimeZone(//@RequestParam(value = "time") String time,
													@RequestParam(value = "fromTimeZone") String fromTimeZone,
													@RequestParam(value = "toTimeZone") String toTimeZone) {
		 // Get the current time in the first time zone
        ZonedDateTime time1 = ZonedDateTime.now(ZoneId.of(fromTimeZone));

        // Get the current time in the second time zone
        ZonedDateTime time2 = ZonedDateTime.now(ZoneId.of(toTimeZone));

        // Convert both times to UTC
        time1 = time1.withZoneSameInstant(ZoneId.of("UTC"));
        time2 = time2.withZoneSameInstant(ZoneId.of("UTC"));

        // Find the difference in milliseconds between the two times
        long difference = ChronoUnit.MILLIS.between(time1, time2);

        //return the difference in the response body
        return new ResponseEntity<>("Time difference is : " + difference + " ms", HttpStatus.OK);
    }*/

}








		// response.append(json.toString(4)); -- to get all attribute

		// String time = json.getString("time");
		// String timeZone2 = json.getString("timeZone");


		//TimeObject timeObject = new TimeObject();
		// timeObject.setTime(json.getString("dateTime"));
		//  timeObject.setUnixtime(json.getString("timeZone"));
		//timeResponse.addTimeObject(time, timeZone2);
		// }
		//return timeResponse;


  /*
	 @PostMapping("/convertedTime")
	 public ResponseEntity<String> getTime(@RequestBody DateConversionReq request) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone(request.getFromTimeZone()));
        String time = formatter.format(request.getTime());
        formatter.setTimeZone(TimeZone.getTimeZone(request.getToTimeZone()));
      //  String convertedTime = formatter.format(request.getTime());


         TimeZone fromTimeZone = TimeZone.getTimeZone(request.getFromTimeZone());
		 TimeZone toTimeZone = TimeZone.getTimeZone(request.getToTimeZone());

		 //String fromOffset =  fromTimeZone.getOffset(request.getTime());
		// String toOffset = toTimeZone.getOffset(request.getTime());

		// String convertedTime = String.valueOf((request.getTime() - (fromOffset - toOffset)));
		 String convertedTime = String.valueOf(23432423);


		 return ResponseEntity.ok(convertedTime);
    }


      import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TimeController {

    @GetMapping("/current-time")
    public String getCurrentTime(@RequestParam(value = "timeZone") List<String> timeZones) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder response = new StringBuilder();
        for (String timeZone : timeZones) {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://www.timeapi.io/api/Time/current/zone?timeZone=" + timeZone;
            String jsonString = restTemplate.getForObject(apiUrl, String.class);
            JsonNode jsonNode = mapper.readTree(jsonString);
            //accessing object
            JsonNode time = jsonNode.get("time");
            //accessing object attribute
            String hour = time.get("hour").asText();
            response.append(hour+"\n");
        }
        return response.toString();
    }
}

    * */



