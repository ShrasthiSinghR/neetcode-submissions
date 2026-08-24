class Solution {
public:
    bool isAnagram(string s, string t) {

        if(s.length() != t.length())
        {
            return false;
        }

        map<char, int> mp;

        // Count characters of s
        for(int i = 0; i < s.length(); i++)
        {
            mp[s[i]]++;
        }

        // Remove characters according to t
        for(int i = 0; i < t.length(); i++)
        {
            if(mp.find(t[i]) == mp.end())
            {
                return false;
            }

            mp[t[i]]--;

            if(mp[t[i]] < 0)
            {
                return false;
            }
        }

        return true;
    }
};
