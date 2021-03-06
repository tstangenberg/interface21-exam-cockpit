/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.interface21.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ameba.jpa.BaseEntity;

/**
 * A Question to be answered.
 *
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "T_QUESTION")
@Inheritance
@DiscriminatorColumn(name="C_DTYPE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
abstract class Question<T extends AnswerDefinition> extends BaseEntity {

    /** Question text. */
    private String text;
    /** An order field is used to sort multiple questions of an exam. */
    @Column(name = "C_ORDER")
    private int order;
    /** A maximum achievable score points. */
    private BigDecimal scorePoints;

    protected Question(String text, int order, BigDecimal scorePoints) {
        this.text = text;
        this.order = order;
        this.scorePoints = scorePoints;
    }
}
