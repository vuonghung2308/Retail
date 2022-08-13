package utils;

import java.sql.ResultSet;
import java.util.List;

public interface Mapper<T> {
    List<T> get(ResultSet resultSet);
}
