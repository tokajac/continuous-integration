package continuous.integration.exposerest.controllers;

import continuous.integration.exposerest.models.BasicCallBody;
import continuous.integration.exposerest.models.BasicResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class HandleBasicCallController {

    static final Logger LOG = LoggerFactory.getLogger(HandleBasicCallController.class);

    @RequestMapping(value = "/basicConsume",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    BasicResponse handleBasicFeature(@RequestBody BasicCallBody couponSubmission) {

        LOG.info( "HandleBasicCallController->handleBasicFeature" );

        return new BasicResponse();
    }
}