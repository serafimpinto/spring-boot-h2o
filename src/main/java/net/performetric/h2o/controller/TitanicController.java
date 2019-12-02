package net.performetric.h2o.controller;

import hex.genmodel.easy.exception.PredictException;
import javax.validation.Valid;
import net.performetric.h2o.model.TitanicInput;
import net.performetric.h2o.model.TitanicScoreResult;
import net.performetric.h2o.service.TitanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by serafimpinto on 02/12/2019
 */
@RestController
public class TitanicController {

  private final TitanicService titanicService;

  @Autowired
  public TitanicController(TitanicService titanicService) {
    this.titanicService = titanicService;
  }

  @PostMapping(value = "/titanic/score", consumes = "application/json", produces = "application/json")
  public ResponseEntity<TitanicScoreResult> score(@Valid @RequestBody TitanicInput input) {

    TitanicScoreResult result;
    try {
      result = titanicService.score(input);
    } catch (PredictException e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }

    return ResponseEntity.ok(result);
  }
}
