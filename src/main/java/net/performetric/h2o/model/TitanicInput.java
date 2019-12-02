package net.performetric.h2o.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by serafimpinto on 02/12/2019
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TitanicInput {

  @NotNull(message = "Please provide a 'pclass'")
  private Double pclass;
  private String sex;
  private Double age;

  @Min(0)
  @Max(9)
  private Double sibsp;

  @Min(0)
  @Max(9)
  private Double parch;
  private Double ticket;
  private Double fare;
  private String cabin;
  private String embarked;
  private Double boat;
  private Double body;
  private String homeDest;

// "pclass" integer (1,2,3)
// "sex" categorical (male, female)
// "age" : double (53.000, 0.9167...)
// "sibsp": integer (0, 1, 2 ... 9 )
// "parch": integer (0, 1, 2 ... 9)
// "ticket": integer (680 .. 3101295)
// "fare": double (151.5500)
// "cabin": categorical ( D43, E68)
// "embarked":  categorical (C, Q, S)
// "boat": integer (1 .. 16)
// "body":  integer (4 .. 328)
// "home.dest": categorical (Victoria BC, West Hoboken NK)
}
