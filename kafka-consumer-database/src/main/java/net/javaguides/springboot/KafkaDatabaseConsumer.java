package net.javaguides.springboot;

import net.javaguides.springboot.entity.WikimediaDatabase;
import net.javaguides.springboot.entity.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {



    private static final Logger LOGGER  = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaDataRepository dataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics = "wikimedia_recentChange", groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("message recieved -> %s ",eventMessage));

        WikimediaDatabase wikimediaData =  new WikimediaDatabase();
        wikimediaData.setWikiEventdata(eventMessage);

         dataRepository.save(wikimediaData);
    }
}
