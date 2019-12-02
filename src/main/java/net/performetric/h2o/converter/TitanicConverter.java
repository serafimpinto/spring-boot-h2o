package net.performetric.h2o.converter;

import hex.genmodel.easy.RowData;
import net.performetric.h2o.model.TitanicInput;
import org.springframework.stereotype.Component;

/**
 * Created by serafimpinto on 02/12/2019
 */
@Component
public class TitanicConverter {

  public RowData convert(TitanicInput titanicInput) {
    RowData rowData = new RowData();
    rowData.put("pclass", titanicInput.getPclass());
    rowData.put("sex", titanicInput.getSex());
    rowData.put("age", titanicInput.getAge());
    rowData.put("sibsp", titanicInput.getSibsp());
    rowData.put("parch", titanicInput.getParch());
    rowData.put("ticket", titanicInput.getTicket());
    rowData.put("fare", titanicInput.getFare());
    rowData.put("cabin", titanicInput.getCabin());
    rowData.put("embarked", titanicInput.getEmbarked());
    rowData.put("boat", titanicInput.getBoat());
    rowData.put("body", titanicInput.getBody());
    rowData.put("home.dest", titanicInput.getHomeDest());
    return rowData;
  }
}
