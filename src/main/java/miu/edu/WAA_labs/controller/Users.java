package miu.edu.WAA_labs.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.WAA_labs.entity.User;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    List<User> users = new ArrayList<>();
}
