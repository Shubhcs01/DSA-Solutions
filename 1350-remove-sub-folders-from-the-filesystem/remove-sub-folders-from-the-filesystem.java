class Solution {
    public List<String> removeSubfolders(String[] folder) {

        List<String> res = new ArrayList<>();

        if(folder.length == 0) return res;
        if(folder.length == 1) {
            res.add(folder[0]);
            return res;
        }

        Arrays.sort(folder); // asc order

        for(String path : folder){
            // Add to result if its first element or if current path starts with last added path + "/"
            if(res.size() == 0 || !path.startsWith(res.get(res.size()-1)+"/")){
                res.add(path);
            }
        }

        return res;
   }
}