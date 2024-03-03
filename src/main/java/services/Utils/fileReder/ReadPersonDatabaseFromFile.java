package services.Utils.fileReder;

import core.entity.Person;
import repository.RepositoryInterface;

import java.io.IOException;
import java.util.List;

public class ReadPersonDatabaseFromFile implements ReadFromFile<List<Person> > {



    @Override
    public List<Person> readFromFile(String path) throws IOException {
        return null;
    }
}
