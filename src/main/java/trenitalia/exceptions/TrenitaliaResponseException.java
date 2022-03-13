package trenitalia.exceptions;


import kong.unirest.HttpResponse;

public class TrenitaliaResponseException extends RuntimeException {
    public TrenitaliaResponseException(HttpResponse<?> response) {
        super("Error in the request, response code: " + response.getStatus() + " with message: " + response.getStatusText()+"\nMake sure your parameters are correct");
    }
}
