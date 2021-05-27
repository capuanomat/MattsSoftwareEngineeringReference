

int firstDuplicate(vector<int> a) {
    for (int val: a) {
        if (a[abs(val) - 1] < 0)
            return abs(val);
        a[abs(val) - 1] *= -1;
    }
    return -1;
}



char firstNotRepeatingCharacter(string s) {

    std::vector<int> count(26, 0);
    for (int i = 0; i < s.size(); i++) {
        count[int(s[i]) - 97]++;
    }

    for (int i = 0; i < s.size(); i++) {
        if (count[int(s[i]) - 97] == 1)
            return s[i];
    }

    return '_';
}

// The top C++ solution (doens't seem more optimal than mine):
char firstNotRepeatingCharacter_Best(string s) {
    int count[26] = {};
    int order[26];
    int i = 0;
    for (c : s)
        if (!count[c-'a']++)
            order[i++] = c-'a';
    for (int j = 0; j < i; ++j)
        if (count[order[j]] == 1)
            return order[j]+'a';
    return '_';
}


vector<vector<int>> rotateImage(vector<vector<int>> a) {

    for (int i = 0; i < a.size(); i++) {
        for (int j = i; j < a[i].size(); j++) {
            int entry = a[i][j];
            a[i][j] = a[j][i];
            a[j][i] = entry;
        }
    }

    for (int i = 0; i < a.size(); i++) {
        for (int j = 0; j < a[i].size() / 2; j++) {
            int entry = a[i][j];
            a[i][j] = a[i][a[i].size() - j - 1];
            a[i][a[i].size() - j - 1] = entry;
        }
    }

    return a;
}

std::vector<std::vector<int>> rotateImage_Best(std::vector<std::vector<int>> a) {
    int n = a.size();
    for(int i = 0; i < n; ++i) {
        for(int j = i; j < n-i-1; ++j) {
            swap(a[i][j],a[j][n-i-1]);
            swap(a[i][j],a[n-i-1][n-j-1]);
            swap(a[i][j],a[n-j-1][i]);
        }

    }
    return a;
}
