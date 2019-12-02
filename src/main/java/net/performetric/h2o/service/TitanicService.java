package net.performetric.h2o.service;

import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.RowData;
import hex.genmodel.easy.exception.PredictException;
import hex.genmodel.easy.prediction.BinomialModelPrediction;
import net.performetric.h2o.converter.TitanicConverter;
import net.performetric.h2o.model.TitanicInput;
import net.performetric.h2o.model.TitanicScoreResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by serafimpinto on 02/12/2019
 */
@Service
public class TitanicService {

  private static final double SURVIVED_THRESHOLD = 0.5;
  private final EasyPredictModelWrapper h2oTitanicModel;
  private final TitanicConverter titanicConverter;

  @Autowired
  public TitanicService(EasyPredictModelWrapper h2oTitanicModel, TitanicConverter titanicConverter) {
    this.h2oTitanicModel = h2oTitanicModel;
    this.titanicConverter = titanicConverter;
  }

  public TitanicScoreResult score(TitanicInput titanicInput) throws PredictException {
    RowData rowData = titanicConverter.convert(titanicInput);

    BinomialModelPrediction binomialPrediction = h2oTitanicModel.predictBinomial(rowData);
    double probability = binomialPrediction.classProbabilities[1]; // probability of survive

    System.out.println(binomialPrediction.classProbabilities[0]);

    System.out.println(binomialPrediction.classProbabilities[1]);

    System.out.println(binomialPrediction.label);

    boolean survived = probability > SURVIVED_THRESHOLD;

    return new TitanicScoreResult(survived);
  }
}
