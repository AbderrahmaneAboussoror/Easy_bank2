package com.AboussororAbderrahmane.app.model.mission;

import com.AboussororAbderrahmane.app.model.affectation.Affectation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mission {
    private String _code;
    private String _name;
    private String _description;
    private List<Affectation> _recruitments;
}
