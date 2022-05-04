package org.example.streamapi;

import org.example.streamapi.model.Bodybuilder;
import org.example.streamapi.model.Friend;
import org.example.streamapi.model.User;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Extension {
    /*
        Given two int numbers a and b, return int [] with values that are in the range between smaller and bigger arg:
        - use IntStream.range
        - swap the argument's values without introducing a new, local variable.
    */
    public int [] streamNumbers(int a, int b) {
        return b>=a ? IntStream.range(a,b).toArray() : IntStream.range(b,a).toArray();
    }

    /*
        Given a list of users, return a User with the given user id. If there is no user with this id,
        return new user with the name "New user", given id, gender "unknown".

        (use Optional API)
    */
    public User getUserByIdOrCreateNew(List<User> users, long userId) {
        List<Long> ids = users
                .stream()
                .map(User::getId)
                .toList();

        int index = ids.indexOf(userId);

        return index != -1 ? users.get(index) : new User(userId, "New user", User.GENDER.UNKNOWN);


    }

    /*
        Given List<Friend>, filter the ones who are available on Saturday and want to party:
        - getAvailableDay returns "Saturday" and
        - getActivity returns "Party"
        - define predicates and use '.and' method.
    */

    public List<String> partyWithFriends(List<Friend> friends) {
        Predicate<Friend> availableOnSaturday = (f -> f.getAvailableDay().equals("Saturday"));
        Predicate<Friend> wantsToParty = (f -> f.getActivity().equals("Party"));
        return friends
                .stream()
                .filter(availableOnSaturday.and(wantsToParty))
                .map(Friend::getName)
                .toList();
    }

    /*
        Return names of sorted bodybuilders.

        Sort List<Bodybuilder> using your custom comparator.

        Write a comparator for type BodyBuilder that will sort bodybuilders by:
        - who can lift more,
        - then who is younger,
        - then name alphabetically.
     */
    public List<String> sortBodybuilders(List<Bodybuilder> bodybuilders) {
        Comparator<Bodybuilder> sortLargestLiftThenYoungestThenName = Comparator.comparing(Bodybuilder::getLift).reversed()
                .thenComparing(Bodybuilder::getAge)
                .thenComparing(Bodybuilder::getName);

        List<Bodybuilder> modifiableBodybuilders = new ArrayList<>(bodybuilders);

        modifiableBodybuilders.sort(sortLargestLiftThenYoungestThenName);

        return modifiableBodybuilders
                .stream()
                .map(Bodybuilder::getName)
                .toList();
    }

}
